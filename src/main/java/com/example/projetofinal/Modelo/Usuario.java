package com.example.projetofinal.Modelo;
    public class Usuario {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        private String nome;
        private String login;
        private String senha;

        public Usuario(String nome, String login, String senha) {
            this.nome = nome;
            this.login = login;
            this.senha = senha;
        }
        public Usuario(int id, String nome, String login, String senha) {
            this.id = id;
            this.nome = nome;
            this.login = login;
            this.senha = senha;
        }
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        @Override
        public String toString() {
            return "Usuario{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", login='" + login + '\'' +
                    ", senha='" + senha + '\'' +
                    '}';
        }
    }
