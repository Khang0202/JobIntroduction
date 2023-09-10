import axios from "axios";
import cookie from "react-cookies";

const SERVER = "http://localhost:8080";
const SERVER_CONTEXT = "JobIntroduction/";

export const endpoints = {
    "getAllEmploymentType": `${SERVER_CONTEXT}api/employmentTypes/getAllEmploymentType`,

    //user
    "login": `${SERVER_CONTEXT}api/user/login`,
    "userInfo": `${SERVER_CONTEXT}api/user/current-user/`,
    "register": `${SERVER_CONTEXT}api/user/register`,
    "users":`${SERVER_CONTEXT}api/user/users/`,

    //role
    "rolelist": `${SERVER_CONTEXT}api/role/rolelist`,

    //job
    "getAllJob": `${SERVER_CONTEXT}api/job/jobslist/`,
    // "test": `${SERVER_CONTEXT}` 
}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization": cookie.load("token")
        }
    })
}

export default axios.create(
    {
        baseURL: SERVER
    }
)