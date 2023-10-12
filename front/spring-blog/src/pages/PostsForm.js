import {useState} from "react";
import styles from "../styles/Form.module.css"
import Button from "../components/Button";
const PostsForm = () => {

    const [title, setTitle] = useState()
    const [content, setContent] = useState()
    const [files, setFiles] = useState([])
    const handlePostSubmit = (event) => {
        event.preventDefault();
        // 서버에 내용 전송
        console.log(title)
        console.log(content)

    }
    const onChangeTitleHandler = (event) => {
        setTitle(event.target.value)
    }

    const onChangeContentHandler = (event) => {
        setContent(event.target.value)
    }

    const onFileChangeHandler = (event) => {
        const selectedFiles = event.target.files;
        setFiles([...files, ...selectedFiles]);
    }

    const onSubmitHandler = (event) => {
        console.log(event)
    }

    return (
        <div className= {styles.container}>
            <form onSubmit={handlePostSubmit} className={styles.form}>
                <input type="text" placeholder="Title" onChange={onChangeTitleHandler} className={styles.input}/>
                <br/>
                <textarea
                    value={content}
                    onChange={onChangeContentHandler}
                    required
                    placeholder="Content"
                >
                </textarea>
                <input type="file" accept="image/*" multiple onChange={onFileChangeHandler} className={styles.input}/>

                <Button onClick={onSubmitHandler}>제출</Button>
            </form>
        </div>
    )
}

export default PostsForm;