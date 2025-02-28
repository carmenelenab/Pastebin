'use strict'

function fetchTexts() {
    axios.get("http://localhost:8080/api/texts")
        .then(response => {
            let output = document.getElementById("output");
            output.innerHTML = "";
            response.data.forEach(text => {
                let div = document.createElement("div");
                if (text.text.length > 50) {
                    div.textContent = text.text.substring(0, 50) + ". . .";
                } else {
                    div.textContent = text.text;
                }
                div.onclick = () => window.location.href = `text.html?id=${text.id}`;
                output.appendChild(div);
            });
        })
        .catch(error => console.error("Error fetching texts:", error));
}

function saveText() {
    let textInput = document.getElementById("textInput").value;
    if (!textInput.trim()) {
        alert("Text cannot be empty!");
        return;
    }
    axios.post("http://localhost:8080/api/texts", { text: textInput })
        .then(response => {
            document.getElementById("textInput").value = "";
            fetchTexts();
        })
        .catch(error => {
            console.error("Error saving text:", error);
            alert("Failed to save text!");
        })
}

document.addEventListener("DOMContentLoaded", fetchTexts);