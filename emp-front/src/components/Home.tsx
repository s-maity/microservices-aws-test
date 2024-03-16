import { useEffect, useState } from "react";
import { fetchAllEmployees } from "../service/empservice";

interface Employee {
  id: number;
  name: string;
  skills: string[];
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
      <div className="row">
        <div className="col-sm-6">
          {employees?.map((emp) => {
            return (
              <div className="row" key={emp.id}>
                <div className="col-sm-2">{emp.name}</div>
                <div className="col-sm-8">
                  {emp.skills.map((skill) => {
                    return (
                      <span className="badge badge-pill bg-primary">
                        {skill}
                      </span>
                    );
                  })}
                </div>
              </div>
            );
          })}
        </div>
        <div className="col-4">
          <div>
            <h3>Add Employee</h3>
          </div>
          <div>
            <form>
              <div className="form-group">
                <label>Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="name"
                  placeholder="Enter Full name"
                />
              </div>
              <div className="form-group">
                <label>Gender</label>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="radio"
                    name="maleRadioOption"
                    id="maleRadio"
                    value="m"
                  />
                  <label className="form-check-label">Male</label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="radio"
                    name="femaleRadioOption"
                    id="femaleRadio"
                    value="f"
                  />
                  <label className="form-check-label">Female</label>
                </div>
              </div>
              <div className="form-group">
                <label>Skills</label>
                <input
                  type="text"
                  className="form-control"
                  id="skills"
                  placeholder="Skills"
                />
              </div>
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
