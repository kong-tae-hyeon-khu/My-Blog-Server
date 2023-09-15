import './App.css';
import LoginForm from "./pages/LoginForm";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import RegisterForm from "./pages/RegisterForm";
import Main from "./pages/Main";
import {getCookie} from "./settings/cookie";
function App() {

    const toekn = getCookie("jwt");

    return (
        <BrowserRouter>
            <div>
                <Routes>
                    <Route path="signin" element={<LoginForm/>}></Route>t
                    <Route path="signup" element={<RegisterForm/>}></Route>
                    <Route path="/" element={toekn ? <Main/> : <LoginForm/>}></Route>
                </Routes>

            </div>
        </BrowserRouter>
    )
}

export default App;
