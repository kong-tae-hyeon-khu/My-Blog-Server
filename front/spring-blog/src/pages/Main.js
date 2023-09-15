import React from 'react'
import {getCookie, removeCookie} from "../settings/cookie";
import Button from "../components/Button";

const Main = () => {

    const onClickGetCookie = () => {
        console.log(getCookie("jwt"));
    }

    const onClickLogout = () => {
        removeCookie("jwt");
        window.location.reload();
    }

    return (
        <div>
            "메인 페이지"
            <button onClick={onClickGetCookie}>버튼</button>
            <Button onClick={onClickLogout}>로그아웃</Button>
        </div>
    )
}

export default Main;