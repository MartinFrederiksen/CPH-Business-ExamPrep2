import React, { useState, useEffect } from 'react';
import Facade from './login/ApiFacade';

export default function Data() {
    const [state, setState] = useState({});
    const [data, setData] = useState([]);
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        Facade.fetchCategory().then(res => setCategories(res));
    }, [])

    const onSubmit = (evt) => {
        evt.preventDefault();
        Facade.fetchJokeV1(Object.keys(state).map(k => state[k] !== "" ? state[k] : null)).then(res => setData(res.jokes));
    }

    const onChange = (evt) => {
        setState({ ...state, [evt.target.id]: evt.target.value });
    }

    return (
        <div className="container">
            <h3>Fetched data</h3>
            <table className="table">
                <thead className="thead-dark">
                    <tr>
                        <th scope="col">Category</th>
                        <th scope="col">Joke</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((joke, index) => <tr key={index}><td>{joke.category}</td><td>{joke.joke}</td></tr>)}
                </tbody>
            </table>
            <form onSubmit={onSubmit} onChange={onChange}>
                <div className="container">
                    <div className="row">
                        <select className={"custom-select col-sm-" + 12/4} id="category1">
                            <option value="" defaultValue>Choose...</option>
                            {categories.map((category, index) => <option value={category.name}>{category.name}</option>)}
                        </select>
                        <select className={"custom-select col-sm-" + 12/4} id="category2">
                            <option value="" defaultValue>Choose...</option>
                            {categories.map((category, index) => <option value={category.name}>{category.name}</option>)}
                        </select>
                        <select className={"custom-select col-sm-" + 12/4} id="category3">
                            <option value="" defaultValue>Choose...</option>
                            {categories.map((category, index) => <option value={category.name}>{category.name}</option>)}
                        </select>
                        <select className={"custom-select col-sm-" + 12/4} id="category4">
                            <option value="" defaultValue>Choose...</option>
                            {categories.map((category, index) => <option value={category.name}>{category.name}</option>)}
                        </select>
                        <input type="submit" value="Send kategorier" className="btn btn-dark col-sm-12" />
                    </div>
                </div>
            </form>
        </div>
    )
}