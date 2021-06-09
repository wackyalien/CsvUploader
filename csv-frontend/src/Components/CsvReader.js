import React, {Component} from 'react';
import axios from 'axios';
import { Button,Form,Table} from 'react-bootstrap';

export default class CsvReader extends Component{
    constructor(){
        super()
        this.state={
            file:null,
            data:[]
        }
    }

    handleFile =(event)=>{
        let file = event.target.files[0]
        this.setState({
            file:file
        })
    }

    handleShow =()=>{
        axios({
            url:'http://localhost:8080/employee',
            method:'GET'
        }).then(response=>{
            this.setState({
                data:response.data
            })
            // console.log(response.data)
        })
        .catch(err=>{console.log(err)})
    }

    handleUpload =(event)=>{
        event.preventDefault()
        console.log(this.state.file)
        let file = this.state.file
        let formdata = new FormData()
        formdata.append('file',file)
        axios({
            url:'http://localhost:8080/upload',
            method:'POST',
            data:formdata,
            // header:{'content-type':'multipart/form-data'}
        }).then(response=>this.handleShow())
        .catch(err=>{console.log(err)})
    }

    render(){
        // const employee ={}
        return(
            <div>
                <h1>Csv Uploader</h1>
                <Form>
                    <div>
                        <label>Select file</label>
                        <input type="file" name="file" onChange={this.handleFile} />
                    </div>
                    <Button variant="primary" onClick={this.handleUpload}>Upload</Button>
                   
                </Form>
                <Table striped bordered hover>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>dob</th>
                            <th>manager</th>
                            <th>salary</th>
                            <th>department</th>
                        </tr>                    
                        {this.state.data.map(ele => (
                            <tr>
                                <td>{ele.id}</td>
                                <td>{ele.name}</td>
                                <td>{ele.dob}</td>
                                <td>{ele.manager}</td>
                                <td>{ele.salary}</td>
                                <td>{ele.department}</td>
                            </tr>
                        ))}
                </Table >
            </div>
        )
    }
}

