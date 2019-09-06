

# Generatore di fiocchi di neve | Diario di lavoro
##### Michele Tomyslak
### Trevano, 06.09.2019

## Lavori svolti


|Orario        |Lavoro svolto                 |
|--------------|------------------------------|
|14:00 - 15:45 |Installato Git          |
|15:45 - 16:30 |Configurato e risolto i problemi con il proxy                          |

##  Problemi riscontrati e soluzioni adottate
Il proxy ha causato problemi nell'installazione la configurazione di GitHub Desktop.
Soluzione trovata aggiungendo 6 linee al file .gitconfig
```markdown
[http]
  proxy = http://michele.tomyslak:PASSWORD@proxy.cpt.local:8080
  proxyAuthMethod = basic
  schannelCheckRevoke = false #Solo se necessario

[https]
  proxy = http://michele.tomyslak:PASSWORD@proxy.cpt.local:8080
  proxyAuthMethod = basic
  schannelCheckRevoke = false #Solo se necessario
```

##  Punto della situazione rispetto alla pianificazione


## Programma di massima per la prossima giornata di lavoro
