import { useEffect, useState } from "react";
import { Accordion, Col, Container, Row } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import Spiner from "../layout/Spiner";
import { useSearchParams } from "react-router-dom";

const Home = () => {
    const [employmentType, setEmploymentType] = useState([])
    const[q] = useSearchParams();

    const [job, setJob] = useState(null)
    useEffect(() => {
        const loadJob = async () => {
            try {
                let e = endpoints["getAllJob"];
                let res = await Apis.get(e);
                let kw = q.get("kw");
                if(kw !== null) e = `${e}?kw=${kw}`
                setJob(res.data)
            } catch (error) {
                console.error(error);
            }
        }
        loadJob();
    }, [q])

    if (job === null) return <Spiner />
    return (
        <>
            <h1 className="text-center">DANH SÁCH TIN TUYỂN DỤNG</h1>
                {job.map(c =>
                    <Accordion key={c.id}>
                        <Accordion.Item eventKey="0">
                            <Accordion.Header>{c.name}</Accordion.Header>
                            <Accordion.Body>
                                <Row>
                                    <Col>Công ty</Col>
                                    <Col xs={10} >{c.company}</Col>
                                </Row>
                                <Row>
                                    <Col>Vị trí tuyển dụng</Col>
                                    <Col xs={10}>{c.employmentType}</Col>
                                </Row>
                                <Row>
                                    <Col>Lương</Col>
                                    <Col xs={10}>{c.salary}</Col>
                                </Row>
                                <Row>
                                    <Col>Mô tả công việc</Col>
                                    <Col xs={10}>{c.description}</Col>
                                </Row>
                                <Row>
                                    <Col>Địa chỉ công ty</Col>
                                    <Col xs={10}>{c.address}</Col>
                                </Row>
                                <Row>
                                    <Col>Số điện thoại liên hệ</Col>
                                    <Col xs={10}>{c.phone}</Col>
                                </Row>
                                <Row>
                                    <Col>Email liên hệ</Col>
                                    <Col xs={10}>{c.emailcompany}</Col>
                                </Row>
                                <Row>
                                    <Col>Thông tin khác</Col>
                                    <Col xs={10}>{c.posterName}</Col>
                                </Row>
                                <Row>
                                    <Col>Người đăng</Col>
                                    <Col xs={10}>{c.otherinfomation}</Col>
                                </Row>
                            </Accordion.Body>
                        </Accordion.Item>
                    </Accordion>)}
        </>
    )
}
export default Home;