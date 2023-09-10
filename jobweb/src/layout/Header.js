import { useContext, useEffect, useState } from "react";
import { Navbar, Nav, Container, NavDropdown, Row, Col, Button, Form, } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import Spiner from "./Spiner";
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import { MyUserContext } from "../App";

const Header = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [employmentType, setEmploymentType] = useState([])
    const [key, setKey] = useState("")
    const nav = useNavigate();
    const[q] = useSearchParams();
    useEffect(() => {
        const loadEmType = async () => {
            // let res = await fetch("http://localhost:8080/JobIntroduction/api/employmentTypes/getAllEmploymentType");
            // let data = await res.json();
            let res = await Apis.get(endpoints["getAllEmploymentType"]);
            setEmploymentType(res.data)
        }
        loadEmType();
    }, [q])

    

    const logout = () => {
        dispatch({
            "type": "logout"
        })
    }

    const search = (evt) => {
        evt.preventDefault();
        nav(`/?key=${key}`)
    }

    if (employmentType === null) return <Spiner />
    return (
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#">JobIntroduction</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link className="nav-link" to="/">Home</Link>
                        <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                        {employmentType.map(c => <Link className="dropdown-item" to={`/?emTypeId=${c.id}`} key={c.id}>{c.employment}</Link>)}
                        </NavDropdown>
                        {user === null ? <>
                        <Link className="nav-link" to="/login">Đăng nhập</Link>
                        <Link className="nav-link" to="/register">Đăng ký</Link>
                        </> 
                         : <>
                            <Link className="nav-link" to="/">{user.firstName}</Link>
                            <Button xs="auto" variant="secondary" onClick={logout}>Đăng xuất</Button>
                        </>}
                        
                    </Nav>
                </Navbar.Collapse>
                <Form onSubmit={search} inline>
                    <Row>
                        <Col xs="auto">
                            <Form.Control
                                type="text"
                                value={key}
                                onChange={e => setKey(e.target.value)}
                                placeholder="Search"
                                className=" mr-sm-2"
                            />
                        </Col>
                        <Col xs="auto">
                            <Button type="submit">Submit</Button>
                        </Col>
                    </Row>
                </Form>
            </Container>
        </Navbar>
    )
}
export default Header;