import { useContext, useState } from "react"
import { Button, Form } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import cookie from "react-cookies";
import { MyUserContext } from "../App";
import { Navigate, useSearchParams } from "react-router-dom";

const Login = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [q] = useSearchParams();

    const login = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                let res = await Apis.post(endpoints['login'], {
                    "username": username,
                    "password": password
                });
                console.info(res.data);
                cookie.save("token", res.data.token);

                let { data } = await authApi().get(endpoints['userInfo']);
                cookie.save("user", data);
                console.info(data);
                dispatch({
                    "type": "login",
                    "payload": data
                });
            } catch (err) {
                console.error(err);
            }
        }
        process();
    }

    if (user !== null) {
        // let next = q.get("next") || "/";
        return <Navigate to={"/"} />
    }

    return (<>


        <h1 className="text-center">ĐĂNG NHẬP</h1>
        <Form onSubmit={login}>
            <Form.Group className="mb-3" controlId="formGroupEmail">
                <Form.Label>Username Or Email</Form.Label>
                <Form.Control type="text" value={username} onChange={e => setUsername(e.target.value)} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formGroupPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" value={password} onChange={e => setPassword(e.target.value)} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formGroupPassword">
                <Button variant="info" type="submit">Đăng nhập</Button>
            </Form.Group>
        </Form>

    </>)
}
export default Login