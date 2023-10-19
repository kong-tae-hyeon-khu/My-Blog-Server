import React, { useState } from 'react';
import styles from "../styles/Form.module.css";
import Button from "../components/Button";

const PostForm = () => {
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [files, setFiles] = useState([]);
    const [postContents, setPostContents] = useState([]);

    const handlePostSubmit = (event) => {
        event.preventDefault();

        // 게시글 내용과 이미지 업로드 처리
        console.log("Title:", title);
        console.log("Content:", content);
        console.log("Images:", files);

        // 게시글을 서버로 업로드하거나 필요한 처리를 수행할 수 있습니다.

        // 리셋 폼
        setTitle('');
        setContent('');
        setFiles([]);
    };

    const onChangeTitleHandler = (event) => {
        setTitle(event.target.value);
    };

    const onChangeContentHandler = (event) => {
        setContent(event.target.value);
    };

    const onFileChangeHandler = (event) => {
        const selectedFiles = event.target.files;
        setFiles([...files, ...selectedFiles]);
    };

    const addPostContent = () => {
        setPostContents([...postContents, { content, files }]);
        // 리셋 폼
        setTitle('');
        setContent('');
        setFiles([]);
    };

    return (
        <div className={styles.container}>
            <form onSubmit={handlePostSubmit} className={styles.form}>
                <input type="text" placeholder="Title" value={title} onChange={onChangeTitleHandler} className={styles.input} />
                <br />
                <textarea
                    value={content}
                    onChange={onChangeContentHandler}
                    required
                    placeholder="Content"
                    className={styles.textarea}
                ></textarea>
                <input type="file" accept="image/*" multiple onChange={onFileChangeHandler} className={styles.input} />
                <Button onClick={addPostContent}>제출</Button>
            </form>

            {postContents.map((post, index) => (
                <div key={index} className={styles.postContainer}>
                    <p>{post.content}</p>
                    <div className={styles.images}>
                        {post.files.map((file, fileIndex) => (
                            <img
                                key={fileIndex}
                                src={URL.createObjectURL(file)}
                                alt="Uploaded Image"
                                className={styles.images}
                            />
                        ))}
                    </div>
                </div>
            ))}
        </div>
    );
};

export default PostForm;
