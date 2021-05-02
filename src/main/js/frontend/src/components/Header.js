import { PageHeader } from 'antd';

const Header = () => (
  <PageHeader
    className="site-page-header"
    onBack={() => null}
    title="Coinzzz"
    subTitle="Welcome to Coinzzz, the number one ranking crypto app"
    style={{ border: "1px solid rgb(235, 237, 240)" }}
  />);

export default Header;