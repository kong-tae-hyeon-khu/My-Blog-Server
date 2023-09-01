import React from 'react'
import {getCookie} from "../settings/cookie";

const Main = () => {

    const onClickGetCookie = () => {
        console.log(getCookie("jwt"));
    }
    return (
        <div>
            "메인 페이지"
            <button onClick={onClickGetCookie}></button>
        </div>
    )
}

export default Main;