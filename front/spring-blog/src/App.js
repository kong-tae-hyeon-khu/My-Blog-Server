import './App.css';
import LoginForm from "./pages/LoginForm";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import RegisterForm from "./pages/RegisterForm";

function App() {
    return (
        <BrowserRouter>
            <div>
                <Routes>
                    <Route path="signin" element={<LoginForm/>}></Route>
                    <Route path="signup" element={<RegisterForm/>}></Route>
                </Routes>

            </div>
        </BrowserRouter>
    )
}

export default App;
