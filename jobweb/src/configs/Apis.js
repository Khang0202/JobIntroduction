import axios from "axios";

const SERVER = "http://localhost:8080";
const SERVER_CONTEXT = "JobIntroduction/";

export const endpoints = {
    "getAllEmploymentType": `${SERVER_CONTEXT}api/employmentTypes/getAllEmploymentType`,

    
    "getAllJob": `${SERVER_CONTEXT}api/job/jobslist`,
}
export default axios.create(
    {
        baseURL: "http://localhost:8080/"
    }
)