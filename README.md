# AC2_ArqWeb

## OBJETIVO 
Criar uma API capaz de gerenciar e organizar a agenda dos professores que lecionarão os cursos.

## LEVANTAMENTO DE REQUISITOS FUNCIONAIS

### ATORES
1. **Secretária**
2. **Professores**

### SECRETÁRIA
#### AÇÕES
1. **Cadastro de Professores:**
   - A secretária poderá cadastrar novos professores, fornecendo informações como nome, CPF, RG, endereço e número de celular.

2. **Cadastro de Cursos:**
   - A secretária poderá cadastrar novos cursos, incluindo descrição, carga horária, objetivos e ementa.
   - Deve ser possível associar quais professores estão habilitados para ministrar cada curso, com base em sua especialização.

3. **Cadastro de Agenda:**
   - A secretária poderá cadastrar a agenda de cursos, informando o curso oferecido, data de início e fim, horário de início e fim, professor responsável, cidade, estado e CEP do local do curso.
   - Ao selecionar o curso, o sistema deve exibir apenas os professores habilitados para ministrar aquele curso.
   - O sistema deve verificar se o professor selecionado já possui compromissos agendados para a mesma data e horário em outros locais. Se sim, o sistema não permitirá o cadastro do professor para o curso em questão.

   **OBSERVAÇÕES:**
   - Quando selecionar o curso, exibirá os professores qualificados para o curso.
   - Se um professor estiver vinculado a algum curso na mesma data, a API deve informar ao usuário que o vínculo não pode ser realizado.

### PROFESSOR
#### AÇÕES
1. **Visualização da Agenda:**
   - Os professores terão acesso apenas à sua própria agenda, onde poderão visualizar os cursos agendados.
   - Os professores poderão imprimir sua agenda, se necessário.

2. **Cadastro de Resumo do Treinamento:**
   - Os professores poderão cadastrar um resumo do treinamento após sua conclusão, informando o que deu certo ou errado durante o curso.
  
# Diagrama de Classe

![Diagrama de Classes](https://github.com/Eduardo-751/AC2_ControleDeAgendamento/assets/92553960/f6d486d0-695a-4e18-9369-d4264b3fb393)


