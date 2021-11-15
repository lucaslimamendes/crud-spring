fetch("/produtos")
    .then(resp => resp.json())
    .then(result => {
        result.forEach(element => {
            let div = document.createElement("tr");
            let id = document.createElement("th");
            let desc = document.createElement("th");
            let preco = document.createElement("th");
            let linha = document.createElement("div");

            let editar = document.createElement("button");
            let excluir = document.createElement("button");

            id.appendChild(document.createTextNode(element.id))
            desc.appendChild(document.createTextNode(element.descricao))
            preco.appendChild(document.createTextNode(element.preco))

            editar.addEventListener("click", () => {
                window.localStorage.setItem("editProduct", JSON.stringify(element));
                location.href='cadastro.html#editar';
            })

            editar.textContent = "Editar"

            excluir.addEventListener("click", () => {

                let res = confirm("Deseja excluir o produto " + element.descricao + " de ID: " + element.id + "?")

                if(res == true)
                    fetch("/produtos/" + element.id, { method: 'DELETE' }).then(() => { document.location.reload() } );
            })
            excluir.textContent = "Excluir";

            linha.append(editar);
            linha.append(excluir);

            div.append(id);
            div.append(desc);
            div.append(preco);
            div.append(linha);

            document.querySelector("#lista").appendChild(div)
        })
    })