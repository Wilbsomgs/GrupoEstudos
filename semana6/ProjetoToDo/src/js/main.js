
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
    const nomeTarefa = document.getElementById('inputNovaTarefa').value.trim();
    const descricaoTarefa = document.getElementById('inputDescricaoTarefa').value.trim();

    if (!nomeTarefa) return alert("Digite uma tarefa!");

    let tarefas = JSON.parse(localStorage.getItem("tarefas")) || [];

    tarefas.push({ nome: nomeTarefa, descricao: descricaoTarefa });

    localStorage.setItem("tarefas", JSON.stringify(tarefas));

    adicionarTarefaNoDOM({ nome: nomeTarefa, descricao: descricaoTarefa });

    document.getElementById('inputNovaTarefa').value = '';
    document.getElementById('inputDescricaoTarefa').value = '';
}

let btnSalvar = document.querySelector('.salvar');
btnSalvar.addEventListener('click', function(){
    const agora = new Date();
    const data = agora.toLocaleString();
    document.getElementById('dataAtual').innerText = data; 
});

function adicionarTarefaNoDOM(tarefa) {
    const modelo = document.getElementById('modelo');
    const clone = modelo.cloneNode(true);
    clone.id = '';
    clone.dataset.id = Date.now();
    clone.style.display = 'block';

    clone.querySelector('h3').textContent = tarefa.nome;
    clone.querySelector('.descricao').textContent = tarefa.descricao;

    const container = document.querySelector('.container-toDo');
    const btn = document.getElementById('btnNovaTarefa');

    container.insertBefore(clone, btn);
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
    const status = card.querySelector('.statusAtual');
    status.textContent = 'Pendente';
    destino.appendChild(card);

}

function moverCardConcluida(botao){
    const card = botao.closest('.card');
    const destino = document.getElementById('concluida');
    const status = card.querySelector('.statusAtual');
    status.textContent = 'Concluído';
    destino.appendChild(card);
}



function carregarAtividadesSalvas() {
    const tarefas = JSON.parse(localStorage.getItem("tarefas"));
    if (!tarefas || !Array.isArray(tarefas)) return;

    tarefas.forEach((tarefa) => {
        adicionarTarefaNoDOM(tarefa);
    });
}

window.onload = function () {
    carregarAtividadesSalvas();
};



function removeCard(botao) {
    const card = botao.closest('.card');
    const nome = card.querySelector("h3").textContent;

    let tarefas = JSON.parse(localStorage.getItem("tarefas")) || [];
    tarefas = tarefas.filter(t => t.nome !== nome);
    localStorage.setItem("tarefas", JSON.stringify(tarefas));

    card.remove();
}

function registrarData(botao) {
    const data = document.getElementById('dataAtual');
    const agora = new Date()
    data.textContent = agora;
}