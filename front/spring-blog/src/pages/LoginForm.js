import React, {useState} from 'react';
import axios from 'axios';
import styles from '../styles/Form.module.css';
import Button from "../components/Button";
import {setCookie} from "../settings/cookie";


const LoginForm = () => {


    const [Email, setId] = useState("");
    const [Password, setPassword] = useState("");

    const onIdHandler = (event) => {
        setId(event.currentTarget.value);
    }

    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value);
    }

    const onSubmitHandler = async (event) => {
        event.preventDefault(); // Prevent Page Reload

        console.log('Email : ' , Email)
        console.log('Password : ', Password)




        try {
            const response = await axios.post('http://localhost:8080/user/signin',
                {
                    email : Email,
                    password : Password
                    }

            );

            if (response.status === 200) {
                console.log("로그인 성공", response.data)
                setCookie("jwt", response.data.token);
            }
            else {
                console.log("로그인 실패", response)
            }
        } catch (err) {
            console.log("에러 ", err)
        }


    }

    return (
        <div className={styles.container}>
            <form onSubmit={onSubmitHandler} className={styles.form}>
                <label className={styles.label}>ID</label>
                <input value={Email} onChange={onIdHandler} className={styles.input}/>

                <br/>

                <label className={styles.label}>Password</label>
                <input value={Password} onChange={onPasswordHandler} className={styles.input}/>

                <br/>
                <Button onClick={onSubmitHandler}>Login</Button>

            </form>
        </div>
    )
}

export default LoginForm;