import {Pipe, PipeTransform} from "@angular/core";
import {I18nService} from "./service/i18n.service";
declare let _:any;
// @Pipe({
//   name: 'translate',
// })
export class TranslatePipe implements PipeTransform {

  constructor(private i18n: I18nService) {
  }

  transform(value:any, args?:any):any{
    let required: string = '';
    if(args === 'startCase'){
      return _.startCase(value);
    }
    if(value.indexOf('*') !== -1 && value.trim().indexOf(' ') === -1){
      required = '*';
      value = value.replace('*', '');
    } else if (value.trim().indexOf(' ') !== -1){
      return value;
    }
    if(!value){
      return;
    }
    return this.i18n.translate(value) + required;
  }
}
