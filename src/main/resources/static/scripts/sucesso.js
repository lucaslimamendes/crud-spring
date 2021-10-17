switch (document.location.hash) {
    case "#editar":
        document.getElementById("metodo").textContent = "Editar" + document.getElementById("metodo").textContent;
        break;
    case "#cadastrar":
        document.getElementById("metodo").textContent = "Cadastro" + document.getElementById("metodo").textContent;
        break;
    default:
        break;
}