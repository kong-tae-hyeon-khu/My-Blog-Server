import React, {useState} from 'react';
import styles from '../styles/Form.module.css'
import Button from "../components/Button";
import axios from "axios";


const RegisterForm = () => {

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");


    const onNameHandler = (event) => {
        setName(event.currentTarget.value);
    }

    const onEmailHandler = (event) => {
        setEmail(event.currentTarget.value);
    }

    const onPasswordHandler = (event) => {
        setPassword(event.currentTarget.value);
    }

    const onSubmitHandler = async (event) => {
        event.preventDefault();
        console.log(name, email, password);
        try {
            const response = await axios.post("http://localhost:8080/user/signup",
                {
                    name : name,
                    email : email,
                    password: password
                })
            if (response.status === 200) {
                console.log("회원가입 성공", response)
            } else {
                console.log("회원가입 실패", response)
            }

        } catch (e) {
            console.log(e)
        }
    }


    return (
        <div className={styles.container}>
            <form className={styles.form} onSubmit={onSubmitHandler}>
                <label>Name</label>
                <input value={name} onChange={onNameHandler}></input>
                <label>Email</label>
                <input value={email} onChange={onEmailHandler}></input>
                <label>Password</label>
                <input value={password} onChange={onPasswordHandler}></input>
                <br/>
                <Button>Sign Up</Button>
            </form>
        </div>
    )
}

export default RegisterForm;