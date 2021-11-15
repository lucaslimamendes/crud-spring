if (document.location.hash == "#editar") {
    let produto = JSON.parse(window.localStorage.getItem("editProduct"));
    document.getElementById("descricao").value = produto.descricao;
    document.getElementById("preco").value = produto.preco;
    document.getElementById("id").textContent = produto.id;

    console.log(produto)

    window.localStorage.removeItem("editProduct");
}

function submitProduto() {
    var form = new FormData();
    form.append("descricao", document.getElementById("descricao").value );
    form.append("preco",  document.getElementById("preco").value);

    if (document.location.hash == "#editar") {
        fetch("/produtos/" + document.getElementById("id").textContent, {
            method: 'PUT',
            body: form
        }).then(() => {
            document.location.href = "sucesso.html#editar"
        });
    } else {
        fetch("/produtos", {
            method: 'POST',
            body: form
        }).then(() => {
            document.location.href = "sucesso.html#cadastrar"
        });
    };
}