import { Layout, Menu } from 'antd';
import '../style/layout.css';
import CoinsTable from './coinsTable'; 
const { Header, Content, Footer } = Layout;

const PageLayout = () => (
    <Layout className="layout">
        <Header>
            <div className="logo" />
            <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
                <Menu.Item key="1">Coins</Menu.Item>
                <Menu.Item key="2">Profile</Menu.Item>
                <Menu.Item key="3">Wallet</Menu.Item>
            </Menu>
        </Header>
        <Content style={{ padding: '0 50px', height: '100vh' }}>
            <div className="site-layout-content"><CoinsTable/></div>
        </Content>
        <Footer style={{ textAlign: 'center' }}>Coins ©2021 Created by Sven</Footer>
    </Layout>
    );

    export default PageLayout;