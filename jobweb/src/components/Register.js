import { useContext, useEffect, useRef, useState } from "react"
import { Alert, Button, Form } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import cookie from "react-cookies";
import { MyUserContext } from "../App";
import { Link, Navigate, useNavigate, useSearchParams } from "react-router-dom";
import Spiner from "../layout/Spiner";

const Register = () => {
    const [user, setUser] = useState({
        "username": "",
        "password": "",
        "firstName": "",
        "lastName": "",
        "sex": "",
        "roleId":"",
        "password": "",
        "email": "",
        "phone": "",
        "confirmPass": ""
    });

    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const file = useRef();
    const [role, setRole] = useState([]);
    const nav = useNavigate();

    useEffect(() => {
        const loadRole = async () => {
            let res = await Apis.get(endpoints["rolelist"]);
            setRole(res.data)
        }
        loadRole();
    }, [])
    const register = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let form = new FormData();

            for (let field in user)
                if (field !== "confirmPass")
                    form.append(field, user[field]);

            form.append("file", file.current.files[0]);

            setLoading(true)
            let res = await Apis.post(endpoints['register'], form);
            if (res.status === 201) {
                nav("/login");
            } else
            setErr("Hệ thống bị lỗi!");
        }

        if(user.password === user.confirmPass) process(); else setErr("Mật khẩu xác nhận không giống");

    }

    const change = (evt, field) => {
        // setUser({...user, [field]: evt.target.value})
        setUser(current => {
            return { ...current, [field]: evt.target.value }
        })
    }

    return (<>


        <h1 className="text-center">ĐĂNG KÝ NGƯỜI DÙNG</h1>
        {err === null?"":<Alert variant="danger">{err}</Alert>}
        <Form onSubmit={register}>
            <Form.Group className="mb-3">
                <Form.Label>Tên</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "firstName")} placeholder="Tên" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Họ và chữ lót</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "lastName")} placeholder="Họ và chữ lót" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Giới tính</Form.Label>
                <Form.Control type="text" onChange={(e) => change(e, "sex")} placeholder="Giới tính" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Ngày sinh</Form.Label>
                <Form.Control type="date" onChange={(e) => change(e, "birthform")} placeholder="Ngày sinh" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Vị trí</Form.Label>
                <Form.Select>
                    {role.map(c => <option  key={c.id} onSelect={(e) => change(e, "roleId")}>{c.role}</option>)}
                </Form.Select>
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Email</Form.Label>
                <Form.Control type="email" onChange={(e) => change(e, "email")} placeholder="Email" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Điện thoại</Form.Label>
                <Form.Control type="tel" onChange={(e) => change(e, "phone")} placeholder="Điện thoại" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control value={user.username} onChange={(e) => change(e, "username")} type="text" placeholder="Tên đăng nhập" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control value={user.password} onChange={(e) => change(e, "password")} type="password" placeholder="Mật khẩu" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Xác nhận mật khẩu</Form.Label>
                <Form.Control value={user.confirmPass} onChange={(e) => change(e, "confirmPass")} type="password" placeholder="Xác nhận mật khẩu" required />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>Ảnh đại diện</Form.Label>
                <Form.Control type="file" ref={file} />
            </Form.Group>
            <Form.Group className="mb-3">
                {loading === true?<Spiner />: <Button variant="info" type="submit">Đăng ký</Button>}
            </Form.Group>
        </Form>

    </>)
}
export default Register