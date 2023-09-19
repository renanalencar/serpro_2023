const prompt = require('prompt-sync')({sigint: true});

// insira as linhas da sua resposta, imediatamente a partir desta linha
calculaFatorial = function(numero) {
    if (numero == 0 || numero == 1)
        return 1;
    else
        return numero * calculaFatorial(numero - 1);
};

var x = parseInt(prompt("Digite um número entre 0 e 100: ")); // Correto!

if (x < 0 || x > 100 || typeof x != 'number' || isNaN(x)) { // Correto!
    console.log("Erro. O número digitado deverá ser maior que 0 ou menor que 100.");
} else {
    var y = calculaFatorial(x);
    console.log(`O fatorial de ${x} é ${y}`);
}