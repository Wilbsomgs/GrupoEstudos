function AddNewTask() {
    const newTask = document.getElementById("renomear");
    if (newTask.style.display === "none" || newTask.style.display === "") {
        newTask.style.display = "block"; // Mostra o elemento
    } else {
        newTask.style.display = "none"; // Oculta o elemento
    }
   
}