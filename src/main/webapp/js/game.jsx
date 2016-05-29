import React from "react";
import Card from "./card.jsx";
import Button from "./button.jsx";
import $ from "jquery";

export default class Game extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            question: "",
            answer: "",
            cardState: ""
        }
    }

    componentDidMount() {
        this.fetch("http://localhost:8080/anki/startGame");
    }

    nextCard() {
        this.fetch("http://localhost:8080/anki/currentCard");
    }

    flipCard() {
        this.setState({
            cardState: this.state.cardState === "flipped" ? '' : "flipped"
        });
    }

    fetch(url) {
        $.ajax({
            url: url,
            dataType: 'json',
            success: function (data) {
                this.setState({
                    answer: data.answer,
                    question: data.question
                });
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    }

    submitEvaluation(evaluation) {
        $.ajax({
            type: "POST",
            dataType: 'json',
            url: "http://localhost:8080/anki/submitEvaluation",
            data: {"evaluation": evaluation},
            success: function (data) {
                this.setState({
                    answer: data.answer,
                    question: data.question
                });
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    }
    
    render() {
        return <div>
            <Card question={this.state.question} answer={this.state.answer} cardState={this.state.cardState}/>
            <Button text="Red" onClick={this.submitEvaluation.bind(this, "RED")}/>
            <Button text="Green" onClick={this.submitEvaluation.bind(this, "GREEN")}/>
            <Button text="Orange" onClick={this.submitEvaluation.bind(this, "ORANGE")}/>
            <Button text="Flip Card" onClick={this.flipCard.bind(this)}/>
        </div>
    }
}