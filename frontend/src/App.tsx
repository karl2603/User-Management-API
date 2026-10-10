import { useState, useEffect } from 'react';
import axios from 'axios';
import LoadingPage from './components/LoadingPage';
import Error404 from './components/Error404';
import "./App.css";

interface userResponse{
  name: string;
  email: string;
  phoneNo: string;
  city: string;
  accountStatus: string;
}

function App() {
  const [loading, setLoading] = useState<boolean>(true);
  const [users, setUsers] = useState<userResponse[] | null>(null);
  const [apiError, setApiError] = useState<boolean>(false);
  const url:string = "http://localhost:8080/";

  async function fetchData(){
    try {
      const response = await axios.get(url+"users");
      const data = response.data;
      setUsers(data);
      setLoading(false);
    } catch (error) {
      console.log("Error Fetching Data");
      setLoading(false);
      setApiError(true);
    }
  }

  useEffect(()=>{
    fetchData();
  },[])
  
  //loading page
  if(loading){
    return(
      <LoadingPage/>
    )
  }

  if(apiError){
    return(
      <Error404 />
    )
  }

  return (
    <>
    <div className='container'>
      {users?.map((user) => (
        <div className='userContainer'>
          <h2 className='userName'>Username : {user.name}</h2>
          <p className='userEmail'>Email Address : {user.email}</p>
          <p className='userPhoneNo'>Phone Number : {user.phoneNo}</p>
          <p className='userCity'>City : {user.city}</p>
          <p className='userAccStatus'>Account Status : {user.accountStatus}</p>
        </div>
      ))}
    </div>
    </>
  )
}

export default App