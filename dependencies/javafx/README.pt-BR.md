# 📦 Configuração do SDK do JavaFX

Este guia explica como baixar o **SDK do JavaFX**, extrair seus arquivos e colocá-los no diretório correto para este projeto.

## 🔽 1. Baixar o SDK do JavaFX

Acesse a página oficial de [Downloads do JavaFX](https://gluonhq.com/products/javafx/) e baixe a versão do SDK compatível com seu sistema:

* Windows: `javafx-sdk-[versão]-windows.zip`
* Linux: `javafx-sdk-[versão]-linux.zip`
* macOS: `javafx-sdk-[versão]-macos.zip`

> 📌 **Versão recomendada:** JavaFX 24.0.1

---

## 📂 2. Extrair o SDK

Após o download, extraia o conteúdo do arquivo `.zip` para uma pasta temporária.

Exemplo (terminal Linux/macOS):

```bash
unzip openjfx-24.0.1_linux-x64_bin-sdk.zip -d ~/Downloads/
```

A pasta extraída ficará assim:

```
openjfx-24.0.1_linux-x64_bin-sdk/
├── legal/
├── lib/             ← precisamos dessa pasta
└── README.md
```

---

## 🚚 3. Copiar a pasta `lib/` para `dependencies/javafx/`

Agora copie todo o conteúdo da pasta `lib/` para a pasta `dependencies/javafx` do projeto.

Exemplo usando terminal:

```bash
mkdir -p dependencies/javafx
cp -r ~/Downloads/openjfx-24.0.1_linux-x64_bin-sdk/lib/* dependencies/javafx/
```

Ou usando interface gráfica (Explorador de Arquivos):

1. Abra a pasta extraída `openjfx-24.0.1_linux-x64_bin-sdk/lib/`.
2. Selecione todos os arquivos dentro dela.
3. Copie e cole esses arquivos dentro da pasta `dependencies/javafx/` do seu projeto.

Depois disso, a estrutura da pasta do seu projeto deve ficar assim:

```
dependencies/
└── javafx/
    ├── javafx.base.jar
    ├── javafx.controls.jar
    ├── javafx.fxml.jar
    ├── javafx.graphics.jar
    └── ... (outros módulos do JavaFX)
```

---

## ✅ Pronto!

Agora você está pronto para compilar e executar o projeto com suporte ao JavaFX:

```bash
chmod +x build.sh
./build.sh
```

> 💡 Se aparecerem erros relacionados a módulos, verifique se todos os arquivos necessários estão presentes na pasta `dependencies/javafx`.