import React, { Component } from "react";
import { Form, Text } from 'react-form';
import "./Register.css";
const API = 'https://localhost:8085/oauth/token'
const base64 = require('base-64');
var qs = require('qs');

function refreshToken(){
let config = {
      method: 'POST',
      headers: { 'Content-Type':'application/x-www-form-urlencoded', 'Authorization': 'Basic '+btoa('testjwtclientid:XY7kmzoNzl100')},
      body: qs.stringify({
        'grant_type': 'password',
        'username': 'admin.admin',
        'password': 'jwtpass'
      })
    }

     fetch(API, config)
    .then(response =>
      response.json()) .then((data) => { 
          localStorage.setItem('token', data.access_token)})     

    }
    

class Register extends Component {

  constructor(props) {
    super(props);

    this.state = {
      users: [], data: []
    };
  }

 handleSubmit(e){

    var token =localStorage.getItem('token');
    if(token==null)
      refreshToken();
    token =  localStorage.getItem('token');
    // let config = {
    //   method: 'POST',
    //   headers: { 'Content-Type':'application/json', 'Authorization': 'Bearer ${localStorage.getItem('token')}')},
    //   body: qs.stringify({
    //     'grant_type': 'password',
    //     'username': 'admin.admin',
    //     'password': 'jwtpass'
    //   })
    // }


    // fetch(API, config)
    // .then(response =>
    //   response.json()) .then((data) => { 
    //     if(data.access_token !=null) {
    //       localStorage.setItem('token', data.access_token);
    //     this.setState( { data });}
    //     else
    //     {

    //     })
 }

  render() {

    return (
      <Form>
  {formApi => (
    <form class="form-style-5">
   
<fieldset>
<legend><span class="number">1</span> Candidate Info</legend>
<input type="text" name="field1" placeholder="First Name *"/>
<input type="text" name="field2" placeholder="Last Name *"/>
<input type="email" name="field3" placeholder="Email *"/>
<input type="text" ref={(ref) => this.uname = ref} name="field4" placeholder="Username*"/>
<input type="password" ref={(ref) => this.password = ref} name="field5" placeholder="Password *"/>
</fieldset>
<input type="submit" onClick={this.handleSubmit.bind(this)} value="Apply" />









      
    </form>
  )}
</Form>
    );
  }
}
 
export default Register;

