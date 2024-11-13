package com.mycompany.brdata;

public class Jogador{  // criado a classe jogador com todas as variáveis do banco e os getters e setters
        private int id;
        private String nome;
        private String clube;
        private String posicao;
        private int gols;
        private int assistencias;
        private int cartoesAmarelos;
        private int cartoesVermelhos; // Setado as variáveis private de acordo com a tabela do banco
        
        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        public String getNome(){
            return nome;
        }
        public void setNome (String nome){
            this.nome = nome;
        }
        public String getClube(){
            return clube;
        }
        public void setClube (String clube){
            this.clube = clube;
        }
        public String getPosicao(){
            return posicao;
        }
        public void setPosicao (String posicao){
            this.posicao = posicao;
        }
        public int getGols(){
            return gols;
        }
        public void setGols (int gols){
            this.gols = gols;
        }    
        public int getAssistencias(){
            return assistencias;
        }
        public void setAssistencias (int assistencias){
            this.assistencias = assistencias;
        }    
        public int getCartoesAmarelos(){
            return cartoesAmarelos;
        }
        public void setCartoesAmarelos (int cartoesAmarelos){
            this.cartoesAmarelos = cartoesAmarelos;
        }    
        public int getCartoesVermelhos(){
            return cartoesVermelhos;
        }
        public void setCartoesVermelhos (int cartoesVermelhos){
            this.cartoesVermelhos = cartoesVermelhos;
        }    

    }

