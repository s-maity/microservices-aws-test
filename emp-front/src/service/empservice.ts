import axios from "axios";

const client = axios.create({
  baseURL: process.env.REACT_APP_BASE_URL, // "http://localhost:8050/api/",
});

export const fetchAllEmployees = () => {
  return client.get("employees").then((response) => {
    return response.data.employees;
  });
};
