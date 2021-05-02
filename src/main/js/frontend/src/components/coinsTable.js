import React, {useEffect, useState} from "react";
import {Table} from "antd";
import { connect } from 'react-redux';
import { fetchCoins } from '../actions/coinActions';

function CoinsTable(props) {
    const [data, setData] = useState([]);
    const columns = [
        {
            title: 'Name',
            dataIndex: 'name',
            key: 'name',
            render: text => <a>{text}</a>,
        },
        {
            title: 'Symbol',
            dataIndex: 'symbol',
            key: 'symbol',
        },
        {
            title: 'Market Cap',
            dataIndex: 'marketCap',
            key: 'marketCap',
        },
        {
            title: 'Tier',
            dataIndex: 'tier',
            key: 'tier'
        },
        {
            title: 'Price',
            dataIndex: 'price',
            key: 'price'
        },
        {
            title: 'Icon',
            dataIndex: 'iconUrl',
            key: 'iconUrl',
            render: (text, record) => {
                return (
                    <img src={record.iconUrl} alt={'Icon'} style={{ width: "35px", height: "auto"}}/>
                );
            }
        }
    ]

    useEffect(() => props.fetchCoins(), []);

    return (
        <Table columns={columns} dataSource={props.coins}/>
    );
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
