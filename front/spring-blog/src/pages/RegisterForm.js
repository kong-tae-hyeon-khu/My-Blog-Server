import React, {useState} from 'react';
import styles from '../styles/Form.module.css'
import Button from "../components/Button";


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

    const onSubmitHandler = (event) => {
        event.preventDefault();
        console.log(name, email, password);
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