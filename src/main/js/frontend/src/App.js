import logo from './logo.svg';
import './App.css';
import React, {useEffect, useState} from "react";
import {Table} from "antd";

function App() {
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
                console.log(record);
                return (
                    <img src={record.iconUrl} alt={'Icon'} style={{ width: "200px", height: "auto"}}/>
                );
            }
        }
    ]

    useEffect(() => {
        fetch('http://localhost:8080/coins')
            .then((response) => {
                if (response.status == 200) {
                    return response.json();
                } else {
                    throw `error with status ${response.status}`;
                }
            })
            .then((coins) => {
                setData(coins);
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);

    return (
        <Table columns={columns} dataSource={data}/>
        // <div className="App">
        //   <header className="App-header">
        //     <img src={logo} className="App-logo" alt="logo" />
        //     <p>
        //       Edit <code>src/App.js</code> and save to reload.
        //     </p>
        //     <a
        //       className="App-link"
        //       href="https://reactjs.org"
        //       target="_blank"
        //       rel="noopener noreferrer"
        //     >
        //       Learn React
        //     </a>
        //   </header>
        // </div>
    );
}

export default App;
