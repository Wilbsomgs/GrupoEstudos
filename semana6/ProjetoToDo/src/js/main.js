
function adicionarTarefaCard() {
    document.querySelector('.overlayNovaTarefa').style.display = 'block';
}

function sairAdicionarTarefa() {
    document.querySelector('.overlayNovaTarefa').style.display = 'none';
}

let cardSelecionado = null;

function renomearCard(botao) {
    const card = botao.closest('.card');
    cardSelecionado = card;

    const nomeAtual = card.querySelector('h3').textContent;

    const titulo = document.getElementById('tituloRenomear');
    if (titulo) {
        titulo.textContent = nomeAtual;
    }

    const input = document.getElementById('inputRenomear');
    if (input) {
        input.value = nomeAtual;
    }

     document.querySelector('.overlayRenomear').style.display = 'block';

    input.value = '';
}


function sairRenomearCard() {
    document.querySelector('.overlayRenomear').style.display = 'none';
}


function adicionarTarefa() {

    const input = document.getElementById('inputNovaTarefa');
    const novaTarefa = input.value.trim();

    if (!novaTarefa) return alert("Digite uma tarefa!");

    let atividades = localStorage.getItem("atividades") || "";
    atividades = atividades ? atividades + "|" + novaTarefa : novaTarefa;
    localStorage.setItem("atividades", atividades);

    const modelo = document.getElementById('modelo');
    const clone = modelo.cloneNode(true);

    clone.id = '';
    clone.dataset.id = Date.now();
    
    clone.style.display = 'block'; 
    clone.querySelector('h3').textContent = novaTarefa;

    const container = document.querySelector('.container-toDo');
    const btn = document.getElementById('btnNovaTarefa'); 

    container.insertBefore(clone, btn); 

    input.value = '';
}

function salvarRenomearCard() {
    const novoNome = document.getElementById('inputRenomear').value.trim();
    if (!novoNome) return alert('Digite um novo nome para a tarefa.');

    if (cardSelecionado) {
        cardSelecionado.querySelector('h3').textContent = novoNome;
    }

    document.querySelector('.overlayRenomear').style.display = 'none';
}



function moverCardPendente(botao) {
    const card  =  botao.closest('.card');
    const destino = document.getElementById('pendente');
    destino.appendChild(card);
}

function moverCardConcluida(botao){
    const card = botao.closest('.card');
    const destino = document.getElementById('concluida');
    destino.appendChild(card);
}



window.onload = function () {
    carregarAtividadesSalvas();
};

window.onload = function () {
    carregarAtividadesSalvas();
};
function carregarAtividadesSalvas() {
    const atividades = localStorage.getItem("atividades");
    if (!atividades) return;

    const lista = atividades.split("|"); // separa as tarefas
    const modelo = document.getElementById("modelo");
    const container = document.querySelector(".container-toDo");
    const btn = document.getElementById("btnNovaTarefa");

    lista.forEach((tarefa) => {
        const clone = modelo.cloneNode(true);
        clone.id = '';
        clone.dataset.id = Date.now();
        clone.style.display = "block";
        clone.querySelector("h3").textContent = tarefa;

        container.insertBefore(clone, btn);
    });
}

function removerAtividade(nomeAtividade) {
    let atividades = localStorage.getItem("atividades");
    if (!atividades) return;

    let lista = atividades.split("|");
    lista = lista.filter(nome => nome !== nomeAtividade);

    localStorage.setItem("atividades", lista.join("|"));
}

function removeCard(botao) {
    const card = botao.closest('.card');
    const nome = card.querySelector("h3").textContent;

    removerAtividade(nome); 
    card.remove();          
}

