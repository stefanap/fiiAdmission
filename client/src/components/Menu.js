  import React, { Component } from "react";
  import {
    Route,
    NavLink,
    HashRouter
  } from "react-router-dom";
  import Register from "./Register";
  import Login from "./Login";
  import Contact from "./Contact";
  import "./Menu.css";
  import fii from '../fii.png';
  require('react-bootstrap');

  class Main extends Component {
    render() {
      return (

        <div>
       
               

<HashRouter>
<div class="row">
<div className="leftMenu col-md-2">
  <div className="App">
                        <header className="App-header">
                                <img src={fii} className="App-logo" alt="logo" />
                        </header>
                        <p className="App-intro">
                        </p>
                </div>
                <ul>
                                        <li class="var_nav"><NavLink to="/login">
                                                <div class="link_bg"></div>
                                                <div class="link_title">
                                                        <div class="icon"> 
                                                                <i class="glyphicons glyphicons-unlock"></i>
                                                        </div>
                                                        <a href="#"><span>Login</span></a>
                                                </div>
                                        </NavLink>
                                </li>
                                <li class="var_nav"><NavLink exact to="/">
                                        <div class="link_bg"></div>
                                        <div class="link_title">
                                                <div class="icon"> 
                                                        <i class="icon-lightbulb icon-2x"></i>
                                                </div>
                                                <a href="#"><span>Inscriere</span></a>
                                        </div>
                                </NavLink>
                        </li>
                        <li class="var_nav"><NavLink to="/contact">
                                <div class="link_bg"></div>
                                <div class="link_title">
                                        <div class="icon"> 
                                                <i class="icon-wrench icon-2x"></i>
                                        </div>
                                        <a href="#"><span>Services</span></a>
                                </div>
                        </NavLink>
                </li>
                <li class="var_nav">
                        <div class="link_bg"></div>
                        <div class="link_title">
                                <div class="icon"> 
                                        <i class="icon-briefcase icon-2x"></i>
                                </div>
                                <a href="#"><span>Marketing</span></a>
                        </div>
                </li>
        </ul>

</div>
        <div className="content col-md-10">
                <Route exact path="/" component={Register}/>
                <Route path="/login" component={Login}/>
                <Route path="/contact" component={Contact}/>
        </div>
        </div>

</HashRouter>



        </div>



        );
      }
    }

    export default Main;