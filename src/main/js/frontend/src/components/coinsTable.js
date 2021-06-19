import React, { useEffect, useRef, useState } from "react";
import { connect } from 'react-redux';
import { fetchCoins } from '../actions/coinActions';
import { Table, Input, Button, Space } from 'antd';
import Popup from "./generic/Popup";
import Highlighter from 'react-highlight-words';
import { SearchOutlined } from '@ant-design/icons';
import { ToastContainer } from 'react-toastify';

function CoinsTable(props) {
    const [searchText, setSearchText] = useState('');
    const [searchedColumn, setSearchedColumn] = useState('');
    const [popup, setPopup] = useState({
        visible: false,
        x: 0, y: 0
    });
    const searchInput = useRef();
    useEffect(() => props.fetchCoins(), []);

    const expandedRowRender = (record) => {
        const columns = [
            {
                title: 'Name',
                dataIndex: 'name',
                key: 'name'
            },
            {
                title: 'Market Cap',
                dataIndex: 'marketCap',
                key: 'marketCap'
            },
            {
                title: 'Tier',
                dataIndex: 'tier',
                key: 'tier'
            }
        ]

        return <Table columns={columns} dataSource={record} pagination={false} />;
    };


    const getColumnSearchProps = dataIndex => ({
        filterDropdown: ({ setSelectedKeys, selectedKeys, confirm, clearFilters }) => (
            <div style={{ padding: 8 }}>
                <Input
                    ref={searchInput}
                    placeholder={`Search ${dataIndex}`}
                    value={selectedKeys[0]}
                    onChange={e => setSelectedKeys(e.target.value ? [e.target.value] : [])}
                    onPressEnter={() => handleSearch(selectedKeys, confirm, dataIndex)}
                    style={{ width: 188, marginBottom: 8, display: 'block' }}
                />
                <Space>
                    <Button
                        type="primary"
                        onClick={() => handleSearch(selectedKeys, confirm, dataIndex)}
                        icon={<SearchOutlined />}
                        size="small"
                        style={{ width: 90 }}
                    >
                        Search
                    </Button>
                    <Button onClick={() => handleReset(clearFilters)} size="small" style={{ width: 90 }}>
                        Reset
                    </Button>
                    <Button
                        type="link"
                        size="small"
                        onClick={() => {
                            confirm({ closeDropdown: false });
                            setSearchText(selectedKeys[0]);
                            setSearchedColumn(dataIndex);
                        }}
                    >
                        Filter
                    </Button>
                </Space>
            </div>
        ),
        filterIcon: filtered => <SearchOutlined style={{ color: filtered ? '#1890ff' : undefined }} />,
        onFilter: (value, record) =>
            record[dataIndex]
                ? record[dataIndex].toString().toLowerCase().includes(value.toLowerCase())
                : '',
        onFilterDropdownVisibleChange: visible => {
            if (visible) {
                setTimeout(() => searchInput.current.select(), 100);
            }
        },
        render: text =>
            searchedColumn === dataIndex ? (
                <Highlighter
                    highlightStyle={{ backgroundColor: '#ffc069', padding: 0 }}
                    searchWords={[searchText]}
                    autoEscape
                    textToHighlight={text ? text.toString() : ''}
                />
            ) : (
                text
            ),
    });

    const handleSearch = (selectedKeys, confirm, dataIndex) => {
        confirm();
        setSearchText(selectedKeys[0]);
    };


    const handleReset = clearFilters => {
        clearFilters();
        setSearchText('');
    };

    const columns = [
        {
            title: 'Icon',
            dataIndex: 'iconUrl',
            key: 'iconUrl',
            render: (text, record) => {
                return (
                    <img src={record.iconUrl} alt={'Icon'} style={{ width: "35px", height: "auto" }} />
                );
            }
        },
        {
            title: 'Symbol',
            dataIndex: 'symbol',
            key: 'symbol',
        },
        {
            title: 'Price',
            dataIndex: 'price',
            key: 'price',
            sorter: (a, b) => a.price - b.price,
        }
    ];

    const onRow = record => ({
        onContextMenu: event => {
            event.preventDefault()
            if (!popup.visible) {
                document.addEventListener(`click`, function onClickOutside() {
                    setPopup({ visible: false });
                    document.removeEventListener(`click`, onClickOutside)
                })
            }
            setPopup({
                record,
                visible: true,
                x: event.clientX,
                y: event.clientY
            });
        }
    })

    return props.error
        ? <div>Error! {props.error.message}</div>
        : props.loading
            ? <div>Loading...</div>
            : <div
                className="site-dropdown-context-menu"
                style={{
                    textAlign: 'center',
                    height: 200,
                    lineHeight: '200px',
                }}
            >
                <Table
                    onRow={onRow}
                    columns={columns}
                    rowKey={ record => record.symbol}
                    expandable={{
                        expandedRowRender: record => expandedRowRender([record]),
                    }}
                    dataSource={props.coins} />
                <Popup {...popup} />
                <ToastContainer/>


            </div>;
}

const mapStateToProps = state => ({
    coins: state.coins.items,
    loading: state.coins.loading,
    error: state.coins.error
});

const mapDispatchToProps = (dispatch, ownProps) => ({
    fetchCoins: () => dispatch(fetchCoins())
})

export default connect(mapStateToProps, mapDispatchToProps)(CoinsTable);
