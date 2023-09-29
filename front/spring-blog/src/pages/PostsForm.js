import {useState} from "react";

const PostsForm = () => {

    const [title, setTitle] = useState()
    const [content, setContent] = useState()

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
    return (
        <div>
            <form onSubmit={handlePostSubmit}>
                <input type="text" placeholder="Title" onChange={onChangeTitleHandler}/>
                <label>게시글 내용</label>
                <textarea
                    value={content}
                    onChange={onChangeContentHandler}
                    required
                >
                </textarea>

                <button type="submit">제출</button>
            </form>


        </div>
    )
}

export default PostsForm;