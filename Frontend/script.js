var tarefaSelecionada = null;

document.getElementById("adicionar_tarefa").onclick = function () {
  document.getElementById("formulario").style.display = "flex";
};

document.getElementById("fechar_formulario").onclick = function () {
  document.getElementById("formulario").style.display = "none";
};

document.getElementById("formulario_tarefa").addEventListener("submit", (e) => {
  e.preventDefault();

  var nome = document.getElementById("nome_tarefa").value;
  var desc = document.getElementById("desc_tarefa").value;
  var prioridade = document.getElementById("prioridade_tarefa").value;

  var tarefa = document.createElement("div");
  tarefa.className = "tarefa";
  tarefa.textContent = prioridade + ": " + nome;

  tarefa.dataset.nome = nome;
  tarefa.dataset.desc = desc;
  tarefa.dataset.prioridade = prioridade;
  tarefa.dataset.status = "todo";

  tarefa.addEventListener("click", () => mostrarTarefa(tarefa));

  document.querySelector(".lista_tarefas_todo").appendChild(tarefa);

  document.getElementById("formulario").style.display = "none";
  document.getElementById("formulario_tarefa").reset();
});

function mostrarTarefa(tarefa) {
  tarefaSelecionada = tarefa;
  document.getElementById("nome_tarefa_mostrar").innerHTML =
    tarefa.dataset.nome;
  document.getElementById("desc_tarefa_mostrar").innerHTML =
    tarefa.dataset.desc;
  document.getElementById("prioridade_tarefa_mostrar").innerHTML =
    tarefa.dataset.prioridade;

  document.getElementById("mostrar_tarefa").style.display = "flex";
}

document.getElementById("fechar_mostrar_tarefa").onclick = function () {
  document.getElementById("mostrar_tarefa").style.display = "none";
};

document.getElementById("deletar_Tarefa").onclick = function () {
  tarefaSelecionada.remove();
  document.getElementById("mostrar_tarefa").style.display = "none";
};

document.getElementById("mover_Todo").onclick = function () {
  document.querySelector(".lista_tarefas_todo").appendChild(tarefaSelecionada);
  tarefaSelecionada.dataset.status = "todo";
  document.getElementById("mostrar_tarefa").style.display = "none";
};

document.getElementById("mover_Doing").onclick = function () {
  document.querySelector(".lista_tarefas_doing").appendChild(tarefaSelecionada);
  tarefaSelecionada.dataset.status = "doing";
  document.getElementById("mostrar_tarefa").style.display = "none";
};

document.getElementById("mover_Done").onclick = function () {
  document.querySelector(".lista_tarefas_done").appendChild(tarefaSelecionada);
  tarefaSelecionada.dataset.status = "done";
  document.getElementById("mostrar_tarefa").style.display = "none";
};

document.getElementById("editar_Tarefa").onclick = function () {
  document.getElementById("formulario").style.display = "flex";

  document.getElementById("nome_tarefa").value = tarefaSelecionada.dataset.nome;
  document.getElementById("desc_tarefa").value = tarefaSelecionada.dataset.desc;
  document.getElementById("prioridade_tarefa").value =
    tarefaSelecionada.dataset.prioridade;

  document.getElementById("mostrar_tarefa").style.display = "none";

  document.getElementById("formulario_tarefa").onsubmit = function (e) {
    e.preventDefault();
    tarefaSelecionada.dataset.nome =
      document.getElementById("nome_tarefa").value;
    tarefaSelecionada.dataset.desc =
      document.getElementById("desc_tarefa").value;
    tarefaSelecionada.dataset.prioridade =
      document.getElementById("prioridade_tarefa");
    tarefaSelecionada.textContent = tarefaSelecionada.dataset.nome;

    document.getElementById("formulario").style.display = "none";
    tarefaSelecionada.remove();
    document.getElementById("formulario_tarefa").reset();
  };
};
