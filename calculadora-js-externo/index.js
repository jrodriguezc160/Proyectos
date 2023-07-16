const pantalla = document.querySelector(".display");
const botones = document.querySelectorAll(".btn");

botones.forEach(boton => {
    boton.addEventListener("click", () => {
        const botonApretado = boton.textContent;

        if (botonApretado === "AC") {
            pantalla.textContent = "0";
            return;
        }

        if (botonApretado === "DE") {
            pantalla.textContent = pantalla.textContent.slice(0, -1);
            if (pantalla.textContent.length < 1 || pantalla.textContent === "ERROR") {
                pantalla.textContent = "0";
            } 
            return;
        }

        if (botonApretado === "=") {
            try {
                pantalla.textContent = eval(pantalla.textContent);
            } catch {
                pantalla.textContent = "ERROR";
            }
            
            return;
        }

        if (pantalla.textContent === "0" || pantalla.textContent === "ERROR") {
            pantalla.textContent = botonApretado;
        } else {
            pantalla.textContent += botonApretado;
        }
        
    })
})

