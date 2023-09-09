import { useEffect, useState } from "react";
import { Navbar, Nav, Container, NavDropdown, Row, Col, Button, Form, } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import Spiner from "./Spiner";
import { useNavigate } from "react-router-dom";

const Header = () => {
    const [employmentType, setEmploymentType] = useState([])
    const [kw, setKw] = useState("")
    const nav = useNavigate();
    useEffect(() => {
        const loadEmType = async () => {
            // let res = await fetch("http://localhost:8080/JobIntroduction/api/employmentTypes/getAllEmploymentType");
            // let data = await res.json();
            let res = await Apis.get(endpoints["getAllEmploymentType"]);
            setEmploymentType(res.data)
        }
        loadEmType();
    }, [])

    const search = (evt) => {
        evt.preventDefault();
        nav(`/?kw=${kw}`)
    }

    if (employmentType === null) return <Spiner />
    return (
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="#home">Home</Nav.Link>
                        <Nav.Link href="#link">Link</Nav.Link>
                        <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                            {employmentType.map(c => <NavDropdown.Item href="#action/3.1" key={c.id}>{c.employment}</NavDropdown.Item>)}
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
                <Form onSubmit={search} inline>
                    <Row>
                        <Col xs="auto">
                            <Form.Control
                                type="text"
                                value={kw}
                                onChange={e => setKw(e.target.value)}
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