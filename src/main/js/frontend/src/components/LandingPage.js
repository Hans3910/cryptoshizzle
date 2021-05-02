import { Carousel } from 'antd';
import React from 'react';
import LoginScreen from './LoginScreen';

const contentStyle = {
    height: '100vh',
    color: '#fff',
    lineHeight: '160px',
    textAlign: 'center',
    background: '#364d79',
};

const LandingPage = () => {
    return (
        <React.Fragment>
            <Carousel dotPosition="bottom">
                <div>
                    <h3 style={contentStyle}>Home</h3>
                </div>
                <div>
                    <h3 style={{
                        height: '20vh',
                        color: '#fff',
                        lineHeight: '160px',
                        textAlign: 'center',
                        background: '#364d79',
                    }}>Login</h3>
                    <LoginScreen />
                </div>
                <div>
                    <h3 style={contentStyle}>Register</h3>
                </div>
                <div>
                    <h3 style={contentStyle}>About</h3>
                </div>
            </Carousel>
        </React.Fragment>
    );
};

export default LandingPage;