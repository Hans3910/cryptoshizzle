import React from "react";
import {
    BrowserRouter as Router,
    Switch,
    Route
} from "react-router-dom";
import './style/App.css';
import LandingPage from "./components/LandingPage";
import PageLayout from "./components/PageLayout";

const App = () => (
    <Router>
        <div>
            {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
            <Switch>
                <Route path="/coins">
                    <PageLayout />
                </Route>
                <Route path="/">
                    <LandingPage />
                </Route>
            </Switch>
        </div>
    </Router>
)

export default App;