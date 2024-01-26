
import { Component, OnInit } from '@angular/core';
import { VendedorService, OperadorService, RecargaService } from '../services'; // Ajusta la ruta según corresponda

@Component({
  selector: 'app-recarga',
  templateUrl: './recarga.component.html',
  styleUrls: ['./recarga.component.css']
})
export class RecargaComponent implements OnInit {

  vendedores: any[] = [];
  operadores: any[] = [];
  monto: number = 0;
  vendedorSeleccionado: string = '';
  operadorSeleccionado: string = '';

  constructor(
    private vendedorService: VendedorService,
    private operadorService: OperadorService,
    private recargaService: RecargaService
  ) {}

  ngOnInit(): void {
    this.obtenerVendedores();
    this.obtenerOperadores();
  }

  obtenerVendedores() {
    this.vendedorService.getVendedores().subscribe(data => {
      this.vendedores = data;
    });
  }

  obtenerOperadores() {
    this.operadorService.getOperadores().subscribe(data => {
      this.operadores = data;
    });
  }

  realizarRecarga() {
    const recargaData = {
      vendedor: this.vendedorSeleccionado,
      operador: this.operadorSeleccionado,
      monto: this.monto
    };

    this.recargaService.postRecarga(recargaData).subscribe(response => {
      console.log('Recarga realizada:', response);
    });
  }
}
