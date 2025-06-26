
const btn = document.getElementById('btnDuplicar');
const modelo = document.getElementById('modelo');
const container = document.getElementById('containerMain');

let contador = 2;

btn.addEventListener('click', () => {
const clone = modelo.cloneNode(true);
clone.id = ''; // Remove o ID duplicado
clone.querySelector('h3').textContent = 'Atividade ' + contador++;
container.insertBefore(clone, btn);
}
);