Este projeto implementa uma tabela hash com uma política de cache LRU (Least Recently Used) para otimizar o armazenamento e recuperação de dados. A tabela hash é uma estrutura de dados que mapeia chaves para valores, e a política LRU garante que os itens menos usados sejam removidos quando o cache atinge sua capacidade máxima.


Funcionalidades

Tabela Hash: Implementa uma tabela hash para armazenar pares chave-valor.

Política LRU: Mantém a ordem de uso dos itens e remove os menos recentemente usados quando o cache está cheio.

Operações de Cache:

Inserção: Adiciona um novo item ao cache.

Busca: Recupera um item do cache.

Remoção: Remove um item do cache, seja por política LRU ou explicitamente.
