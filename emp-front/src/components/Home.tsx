import { useEffect, useState } from "react";
import { fetchAllEmployees } from "../service/empservice";

interface Employee {
  id: number;
  name: string;
}
const Home = () => {
  const [employees, setEmployees] = useState<Employee[]>([]);

  useEffect(() => {
    initData();
  }, []);

  const initData = async () => {
    const employees = await fetchAllEmployees();
    setEmployees(employees);
  };
  return (
    <div className="container-fluid">
      <h3 className="header text-info">Employees</h3>
      <div>
        {employees?.map((emp) => {
          return <p key={emp.id}>{emp.name}</p>;
        })}
      </div>
    </div>
  );
};

export default Home;
