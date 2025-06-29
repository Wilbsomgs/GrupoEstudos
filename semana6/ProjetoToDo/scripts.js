
function adicionarTarefaCard() {
    document.querySelector('.overlayNovaTarefa').style.display = 'block';
}

function sairAdicionarTarefa() {
    document.querySelector('.overlayNovaTarefa').style.display = 'none';
}

function renomearCard() {
    document.querySelector('.overlayRenomear').style.display = 'block';
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
    input.value = "";
    alert("Atividade adicionada!");

    const modelo = document.getElementById('modelo');
    const btn = document.getElementById('salvar');
    const container = document.getElementById('containerCard');

    const clone = modelo.cloneNode(true)
    clone.id = ''; // Remove ID duplicado
    clone.querySelector('h3').textContent = novaTarefa;
    container.insertBefore(clone, btn);

    input.value = '';
    alert('Atividade adicionada!');
}


function mostrarAtividades() {
      const lista = document.getElementById("listaAtividades");
      lista.innerHTML = ""; // Limpa antes de mostrar

      const atividades = localStorage.getItem("atividades");
      if (!atividades) {
        lista.innerHTML = "<li>Nenhuma atividade salva</li>";
        return;
      }

      const atividadesArray = atividades.split("|");
      atividadesArray.forEach(atividade => {
        const li = document.createElement("li");
        li.textContent = atividade;
        lista.appendChild(li);
    });
}