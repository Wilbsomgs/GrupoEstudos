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
    const descricaoAtual = card.querySelector('.descricao').textContent;

    document.getElementById('tituloRenomear').textContent = nomeAtual;
    document.getElementById('inputRenomear').value = nomeAtual;
    document.getElementById('inputNovaDescricao').value = descricaoAtual;

    document.querySelector('.overlayRenomear').style.display = 'block';
}

function sairRenomearCard() {
    document.querySelector('.overlayRenomear').style.display = 'none';
}

function adicionarTarefa() {
    const nomeTarefa = document.getElementById('inputNovaTarefa').value.trim();
    const descricaoTarefa = document.getElementById('inputDescricaoTarefa').value.trim();

    if (!nomeTarefa) {
        alert("Digite uma tarefa!");
        return;
    }

    const dataCriacao = new Date().toLocaleString();
    const novoId = Date.now();

    if (typeof novoId !== 'number' || isNaN(novoId)) {
        alert("Erro ao gerar ID da tarefa. Tente novamente.");
        return;
    }

    const novaTarefa = {
        id: novoId,
        nome: nomeTarefa,
        descricao: descricaoTarefa,
        dataCriacao: dataCriacao,
        status: 'todas'
    };

    let tarefas = JSON.parse(localStorage.getItem("tarefas")) || [];
    tarefas.push(novaTarefa);
    localStorage.setItem("tarefas", JSON.stringify(tarefas));

    adicionarTarefaNoDOM(novaTarefa);

    document.getElementById('inputNovaTarefa').value = '';
    document.getElementById('inputDescricaoTarefa').value = '';
    sairAdicionarTarefa();
}

function adicionarTarefaNoDOM(tarefa) {
    if (!tarefa || typeof tarefa.id === 'undefined') {
        console.error("Erro: Tarefa ou ID da tarefa inválido ao tentar adicionar ao DOM.");
        return;
    }

    const modelo = document.getElementById('modelo');
    if (!modelo) {
        console.error("Erro: Elemento com ID 'modelo' não encontrado no DOM. Verifique seu HTML.");
        return;
    }

    const existingCard = document.getElementById(`card-${tarefa.id}`);
    if (existingCard) {
        existingCard.remove();
    }

    const clone = modelo.cloneNode(true);
    clone.id = `card-${tarefa.id}`;
    clone.dataset.id = tarefa.id;
    
    clone.style.display = 'block';
    clone.style.position = 'relative';

    clone.querySelector('h3').textContent = tarefa.nome;
    clone.querySelector('.descricao').textContent = tarefa.descricao;
    clone.querySelector('.data').textContent = tarefa.dataCriacao || "Data não disponível";
    clone.querySelector('.statusAtual').textContent = tarefa.status;

    const btnPendente = clone.querySelector('.btnPendente');
    if (btnPendente) {
        btnPendente.onclick = () => mudarStatus(tarefa.id, 'pendente');
    }
    const btnConcluir = clone.querySelector('.btnConcluir');
    if (btnConcluir) {
        btnConcluir.onclick = () => mudarStatus(tarefa.id, 'concluido');
    }
    const btnRenomear = clone.querySelector('.btnRenomear');
    if (btnRenomear) {
        btnRenomear.onclick = (event) => renomearCard(event.currentTarget);
    }
    const btnExcluir = clone.querySelector('.btnExcluir');
    if (btnExcluir) {
        btnExcluir.onclick = (event) => removeCard(event.currentTarget);
    }

    let container;
    if (tarefa.status === "pendente") {
        container = document.getElementById('pendente');
    } else if (tarefa.status === "concluido") {
        container = document.getElementById('concluido');
    } else {
        container = document.getElementById('todas');
    }

    if (!container) {
        console.error(`Erro: Container para status '${tarefa.status}' não encontrado.`);
        return;
    }

    const btnNovaTarefa = document.getElementById('btnNovaTarefa');
    if (container.id === 'todas' && btnNovaTarefa && container.contains(btnNovaTarefa)) {
        container.insertBefore(clone, btnNovaTarefa);
    } else {
        container.appendChild(clone);
    }
}

function mudarStatus(id, novoStatus) {
    let tarefas = JSON.parse(localStorage.getItem("tarefas")) || [];
    let tarefaMovida = null;

    tarefas = tarefas.map(tarefa => {
        if (Number(tarefa.id) === Number(id)) {
            tarefa.status = novoStatus;
            tarefaMovida = tarefa;
        }
        return tarefa;
    });

    localStorage.setItem("tarefas", JSON.stringify(tarefas));

    if (tarefaMovida) {
        adicionarTarefaNoDOM(tarefaMovida);
    }
}

function carregarAtividadesSalvas() {
    const tarefas = JSON.parse(localStorage.getItem("tarefas"));

    if (!tarefas || !Array.isArray(tarefas)) {
        return;
    }

    const todasContainer = document.getElementById('todas');
    const pendenteContainer = document.getElementById('pendente');
    const concluidoContainer = document.getElementById('concluido');

    if (todasContainer) todasContainer.querySelectorAll('.card').forEach(card => card.remove());
    if (pendenteContainer) pendenteContainer.querySelectorAll('.card').forEach(card => card.remove());
    if (concluidoContainer) concluidoContainer.querySelectorAll('.card').forEach(card => card.remove());

    const btnNovaTarefa = document.getElementById('btnNovaTarefa');
    if (todasContainer && btnNovaTarefa) {
        todasContainer.appendChild(btnNovaTarefa);
    }

    tarefas.forEach((tarefa) => {
        adicionarTarefaNoDOM(tarefa);
    });
}

function salvarRenomearCard() {
    const novoNome = document.getElementById('inputRenomear').value.trim();
    const novaDescricao = document.getElementById('inputNovaDescricao').value.trim();

    if (!novoNome) {
        alert('Digite um novo nome para a tarefa.');
        return;
    }

    if (cardSelecionado) {
        const id = Number(cardSelecionado.dataset.id);

        cardSelecionado.querySelector('h3').textContent = novoNome;
        cardSelecionado.querySelector('.descricao').textContent = novaDescricao;

        let tarefas = JSON.parse(localStorage.getItem("tarefas")) || [];
        tarefas = tarefas.map(tarefa => {
            if (Number(tarefa.id) === id) {
                tarefa.nome = novoNome;
                tarefa.descricao = novaDescricao;
            }
            return tarefa;
        });

        localStorage.setItem("tarefas", JSON.stringify(tarefas));
    }

    document.querySelector('.overlayRenomear').style.display = 'none';
}

function removeCard(botao) {
    const card = botao.closest('.card');
    
    if (!card) {
        console.error("Erro: Não foi possível encontrar o card pai do botão da lixeira.");
        return;
    }

    const id = Number(card.dataset.id);
    
    if (isNaN(id)) {
        console.error("Erro: ID da tarefa é NaN. Não é possível remover.");
        return;
    }

    let tarefas = JSON.parse(localStorage.getItem("tarefas")) || [];

    tarefas = tarefas.filter(tarefa => Number(tarefa.id) !== id); 

    localStorage.setItem("tarefas", JSON.stringify(tarefas));

    card.remove();
}

window.onload = function () {
    carregarAtividadesSalvas();
};

const menu = document.getElementById('menu');
const headerPage = document.getElementById('header-Ocultar');

if (document.getElementById('botaoMenu')) {
    document.getElementById('botaoMenu').addEventListener('click', () => {
        if (menu) menu.style.display = 'block';
        document.body.style.backgroundColor = 'rgba(0, 0, 0, 0.3)';
        if (headerPage) headerPage.style.display = 'none';
    });
}  

if (document.getElementById('voltar')) {
    document.getElementById('voltar').addEventListener('click', () => {
        if (menu) menu.style.display = 'none';
        document.body.style.backgroundColor = 'white';
        if (headerPage) headerPage.style.display = 'flex';
    });
}