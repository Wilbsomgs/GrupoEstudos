function adicionarTarefa() {
    const input = document.getElementById('inputNovaTarefa');
    const novaTarefa = input.value.trim();

    if (!novaTarefa) return alert("Digite uma tarefa!");

    let atividades = localStorage.getItem("atividades") || "";
    atividades = atividades ? atividades + "|" + novaTarefa : novaTarefa;
    localStorage.setItem("atividades", atividades);

    const modelo = document.getElementById('modelo');
    const container = document.getElementById('containerCard');

    const clone = modelo.cloneNode(true);
    clone.id = '';
    clone.style.display = 'block'; // mostra o card clonado
    clone.querySelector('h3').textContent = novaTarefa;
    container.appendChild(clone); // ou insertBefore(clone, btn) se btn estiver dentro

    input.value = '';
    alert('Atividade adicionada!');
}
